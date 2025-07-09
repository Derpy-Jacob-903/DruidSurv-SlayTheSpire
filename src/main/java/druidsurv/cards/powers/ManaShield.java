package druidsurv.cards.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.ManaShieldPower;

import static druidsurv.ModFile.makeID;

public class ManaShield extends AbstractEasyCard {
    public final static String ID = makeID("ManaShield");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public ManaShield() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF, "ManaShield_CardArt");
        baseBlock = 20;
        this.exhaust = true;
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        //blck();
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new ManaShieldPower(p, block), block, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(10);
    }
}