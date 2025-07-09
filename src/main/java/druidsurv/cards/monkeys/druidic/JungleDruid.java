package druidsurv.cards.monkeys.druidic;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WraithFormPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.colorless.Strike_Thorn;
import druidsurv.powers.monkeys.JBPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

public class JungleDruid extends AbstractEasyCard {
    public final static String ID = makeID("JunglesBounty");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public JungleDruid() {
        super(ID, 3, CardType.POWER, CardRarity.RARE, CardTarget.SELF, "JunglesBounty_CardArt");
        baseMagicNumber = magicNumber = 4;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        MultiCardPreview.add(this, new Strike_Thorn());

        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new JBPower(p, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new WraithFormPower(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));

        makeInHand(new Strike_Thorn());
    }

    @Override
    public void upp() {
        upgradeMagicNumber(2);
    }
}