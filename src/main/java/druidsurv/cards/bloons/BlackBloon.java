package druidsurv.cards.bloons;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class BlackBloon extends AbstractEasyCard {
    public final static String ID = makeID("BlackBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public BlackBloon() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF, "BlackBloon_CardArt");
        baseBlock = 7;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.ADVANCED);
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new DrawCardNextTurnPower(p, 1), 2, true, AbstractGameAction.AttackEffect.NONE));
        bloonBlck();
    }

    @Override
    public void upp()
    {
        upgradeBlock(5);
    }
}