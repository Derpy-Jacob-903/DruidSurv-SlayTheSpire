package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.ManaShieldPower;
import druidsurv.powers.strengthenator;

import static druidsurv.ModFile.makeID;

public class ManaShield extends AbstractEasyCard {
    public final static String ID = makeID("ManaShield");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public ManaShield() {
        super(ID, 0, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 5;
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        setBackgroundTexture("druidsurvResources/images/512/power_skill.png", "druidsurvResources/images/1024/power_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        blck();
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new ManaShieldPower(p, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}